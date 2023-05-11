pipeline {
    agent any
    environment {
        gitcommit = "${gitcommit}"
    }
    tools {
        maven 'maven-jenkins'
        jdk 'jdk-jenkins'
    }

    stages {

        stage('Git pull') {
          steps {
            script {
              checkout scm
              sh "git rev-parse --short HEAD > .git/commit-id"  
              gitcommit = readFile('.git/commit-id').trim()
            }
          }  
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }    
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube') {
          steps {
            script {
              // requires SonarQube Scanner 2.8+
              def scannerHome = tool 'sonar-jenkins'
            }
            withSonarQubeEnv('sonar-jenkins') { 
		    // You can override the credential to be used
      		sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
    		}
          }
        }
        stage('Deploy') {
	  steps {
             sh 'mvn spring-boot:run -Dserver.port=8081 &'
          }
       }
    }
}
