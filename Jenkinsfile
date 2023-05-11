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
        stage('Docker Build & Push') {
          steps {
            script {  
              docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
                def appmavenjenkins = docker.build("quisange/tesis:${gitcommit}", ".")
                appmavenjenkins.push()
              }
            }  
          }  
        }
        stage('Deploy') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}
