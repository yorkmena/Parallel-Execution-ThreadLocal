package practice;

public class ArrayProblems {


    public static void main(String args[]){

//        //findMaxConsecutiveOnes
//        int[] arr1 = {1,1,0,1,1,1};
//        System.out.println(findMaxConsecutiveOnes(arr1));


//        //Find Numbers with Even Number of Digits
//        int[] arr2 = {12,345,2,6,7896,2211,221};
//        System.out.println(findNumbersWithEvenNumberOfDigits(arr2));

          //Finding sum of digits of a number until sum becomes single digit
          int number = 5674;
          //System.out.println(sumOfDigitsTillSingleDigit(number));

    }

    static int findMaxConsecutiveOnes(int arr[]) {
        int count = 0; //initialize count
        int result = 0; //initialize max

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // Reset count when 0 is found
            if (arr[i] == 0)
                count = 0;

                // If 1 is found, increment count
                // and update result if count becomes
                // more.
            else
            {
                count++;//increase count
                result = Math.max(result, count);
            }
        }
        return result;
    }

    public static int findNumbersWithEvenNumberOfDigits(int[] nums) {

        int countOfEvenNumberOfDigits=0;
        int count = 0;
        for (int num: nums){

//            // 1st way to count number of digits in a number
//            while (num != 0){
//                count++;
//                num = num/10;
//            }

            //2nd way to count number of digits in a number using recursion.
            count = countDigitsInNumber(num);

            //To check if digit is even or not
            if (count % 2 == 0){
                countOfEvenNumberOfDigits++;
            }
            count = 0;
        }
        return countOfEvenNumberOfDigits;

    }
    public static int countDigitsInNumber(int num){
        if (num == 0){
            return 0;
        }
        return countDigitsInNumber(num/10)+1;
    }

  public static int sumOfDigitsTillSingleDigit(int num){
       //Fist approach using 2 functions (or 2 loops )
//        int sum = sumOfDigits(num);
//        while (sum/10!=0){
//           sum = sumOfDigits(sum);
//        }
//        return sum;

      // second approach using 1 loop only.
      int sum=0;
      while (num !=0 || sum/10!=0){
          if(num == 0){
              num = sum;
              sum = 0;
          }
          sum=sum+num%10;
          num=num/10;
      }
      return sum;
  }

  public static int sumOfDigits(int num){
//        int sum=0;
//        while (num !=0 ){
//            sum=sum+num%10;
//            num=num/10;
//        }
//        return sum;

        //using recursion
      if (num==0){
          return 0;
      }

      return sumOfDigits(num/10) + num%10;

  }


}