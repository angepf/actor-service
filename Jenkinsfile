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

        stage('Verificación SCM') {
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
        stage('SonarQube analysis') {
          steps {
            script {
              // requires SonarQube Scanner 2.8+
              scannerHome = tool 'sonar-jenkins'
            }
            withSonarQubeEnv('SonarQube Scanner') {
              sh "${scannerHome}/bin/sonar-scanner"
            }
          }
        }
        stage('Deploy') {
			steps {
			    bat "mvn jar:jar deploy:deploy"
			}
		}
    }
}
