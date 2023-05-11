pipeline {
    agent any
    
    tools {
        jdk 'jdk-jenkins'
    }
    
    stages {
        stage('Which Java?') {
                steps {
                    sh 'java --version'
                }
            }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
