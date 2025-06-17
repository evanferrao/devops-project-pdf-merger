pipeline {
    agent any

    environment {
        IMAGE_NAME = 'pdf-merger-app'
        CONTAINER_NAME = 'pdfmerger'
        JAR_NAME = 'target/pdf-merger-1.0.0.jar'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'git@ubuntu:/home/git/pdf-merger.git', branch: 'master'
            }
        }

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

        stage('Puppet Setup') {
            steps {
                sh 'sudo puppet apply manifests/pdfmerger.pp'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ${IMAGE_NAME} .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh """
                docker rm -f ${CONTAINER_NAME} || true
                docker run -d -p 1234:1234 --name ${CONTAINER_NAME} ${IMAGE_NAME}
                """
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
