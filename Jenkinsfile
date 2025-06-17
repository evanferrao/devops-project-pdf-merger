pipeline {
    agent any

    environment {
        IMAGE_NAME = 'pdf-merger-app'
        CONTAINER_NAME = 'pdfmerger'
        JAR_NAME = 'target/pdf-merger-1.0.0.jar'
    }

    stages {
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Ansible Verification') {
            steps {
                sh 'ansible-playbook -i ansible/hosts ansible/deploy.yml'
            }
        }
    }

    post {
        success {
            echo '✅ Build and Deployment Successful!'
        }
        failure {
            echo '❌ Something went wrong!'
        }
    }
}
