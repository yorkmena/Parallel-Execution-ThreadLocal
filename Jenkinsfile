#!groovy

node('master') {

    // Define the docker container variables to stop them at the end of the pipeline
    def sel_hub
    def sel_chrome
    def sel_firefox

    // In the preparation phase the three containers are run to parallelize the execution of chrome and firefox testing
    stage('Preparation') {
        sel_hub = docker.image('selenium/hub').run('-p 4444:4444 --name selenium-hub')
        sel_chrome = docker.image('selenium/node-chrome-debug').run('-p 5901:5900 --link selenium-hub:hub')
        sel_firefox = docker.image('selenium/node-firefox-debug').run('-p 5902:5900 --link selenium-hub:hub')
    }

    stage('Checkout') {
        checkout scm
        echo 'Code checkout'
    }

    stage('Run tests') {

    withMaven(maven: 'Maven 3') {
                sh 'mvn clean test -Dbrowser=${browser}'
              }
    }
}
