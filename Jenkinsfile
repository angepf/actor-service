pipeline {
    agent any
    
    tools {
        maven 'maven-jenkins'
        jdk 'jdk-jenkins'
    }
    
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
