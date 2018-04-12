#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
        echo 'Code checkout'
    }

    stage('Run tests') {

    withMaven(maven: 'Maven 3') {
                sh 'mvn clean test'
              }
    }
}
}
