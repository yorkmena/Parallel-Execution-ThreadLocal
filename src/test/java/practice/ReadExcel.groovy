import org.apache.poi.ss.util.*;
import org.apache.poi.ss.usermodel.*
import org.json.simple.JSONArray
import org.json.simple.JSONObject;

@Grab('org.apache.poi:poi:4.1.2')
@Grab('org.apache.poi:poi-ooxml:4.1.2')
@Grab('com.googlecode.json-simple:json-simple:1.1.1')

class ReadExcel {

    static def path = "/Users/ashish/Downloads/hotel.xlsx";

    static void main(String[] args) {
        //println('Hello World');
        ReadExcel r = new ReadExcel();
        r.readData();
    }

    def readData() {
        InputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Iterator rowIterator = sheet.rowIterator();
        Row row = rowIterator.next()
        Map headerRow = new LinkedHashMap<String, String>();

//      println ("getPhysicalNumberOfRows: " + sheet.getPhysicalNumberOfRows());
//      println("sheet.getLastRowNum: " + sheet.getLastRowNum());

        String rowD;
        int index;
        for (Cell cell : row) {
            index = cell.getColumnIndex()
            rowD = cell.getRichStringCellValue().getString();
            headerRow.put(rowD, index)
        }
        headerRow.remove("Service");

        //headerRow.forEach((k,v) -> println(k + ","+ v ))
        ArrayList<CellAddress> serviceAddress = new ArrayList<CellAddress>()

        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            String serviceColumnCell = row.getCell(0).getStringCellValue();
            if (serviceColumnCell != null && serviceColumnCell != "" && serviceColumnCell != " ") {
                serviceAddress.add(row.getCell(0).address)
            }
        }

//        for (CellAddress s : serviceAddress) {
//            println(s.row)
//        }
        ArrayList<service1> serviceList = new ArrayList<service1>();

        for (int i = 0; i < serviceAddress.size(); i++) {
            String serviceName;
            int startRow;
            int endRow;

            CellAddress c = serviceAddress.get(i);
            serviceName = getValueOfCell(c.row, 0)
            startRow = c.row;
            if (i == serviceAddress.size() - 1) {
                endRow = sheet.getLastRowNum();
            } else {
                endRow = serviceAddress.get(i + 1).row - 1
            }
            //println(serviceName + startRow + endRow);
            serviceList.add(new service1(serviceName, startRow, endRow))
        }

//        for (int i = 0; i < serviceList.size(); i++) {
//            service s = serviceList[i];
//            String name = s.serviceName;
//            int start = s.start;
//            int end = s.end;
//
//            println("*******New Service***********")
//            println("Service Name: " + name);
//            Set<String> headerKey = headerRow.keySet();
//            for (String component : headerKey) {
//                println(component + ":");
//                int columnNumber = headerRow.get(component);
//                for (int j = start; j <= end; j++) {
//                    String cellValue = (String) getValueOfCell(j, columnNumber)
//                    if (cellValue != "" && cellValue != " " && cellValue != null)
//                        println(cellValue);
//                }
//            }
//        }

        JSONObject outer = new JSONObject();
        //JSONArray middle = new JSONArray();
        JSONObject inner;
        for (int i = 0; i < serviceList.size(); i++) {
            service s = serviceList[i];
            String name = s.serviceName;
            int start = s.start;
            int end = s.end;
             inner = new JSONObject();
            Set<String> headerKey = headerRow.keySet();
            for (String component : headerKey) {
               // println(component + ":");
                JSONArray component_array = new JSONArray();
                int columnNumber = headerRow.get(component);
                for (int j = start; j <= end; j++) {
                    String cellValue = (String) getValueOfCell(j, columnNumber)
                    if (cellValue != "" && cellValue != " " && cellValue != null)
                    component_array.add(cellValue);
                }
                inner.put(component, component_array);
            }
            outer.put(name,inner)
        }

        FileWriter file = new FileWriter("./File.json");
        file.write(outer.toJSONString());
        file.close();
    }

    static def getValueOfCell(int i, int j) {
        //def path = "/Users/ashish/Downloads/hotel.xlsx";
        InputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        return sheet.getRow(i).getCell(j).getStringCellValue().toString();
    }
}

class service {
    public String serviceName
    public int start
    public int end

    service(String serviceName, int start, int end) {
        this.serviceName = serviceName;
        this.start = start;
        this.end = end;
    }
}