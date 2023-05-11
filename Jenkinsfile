pipeline {
    agent any
    
    tools {
        maven 'maven-jenkins'
        jdk 'Java17'
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
