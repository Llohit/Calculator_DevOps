pipeline {
    environment{
        imageName = ""
    }
    agent any

    stages {
        stage('Git pull') {
            steps {
                git branch: 'main', url: 'https://github.com/Llohit/Calculator_DevOps'
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Docker build to images') {
            steps {
                script{
                    imageName = docker.build "lohitpoojary/calculator-using-devops:latest"
                }
            }
        }
        stage('Login to dockerhub and push image') {
            steps {
                script{
                    docker.withRegistry('', 'dockerhub'){
                        imageName.push()
                    }
                }
                sh "docker rmi lohitpoojary/calculator-using-devops:latest"
            }
        }
        stage('Ansible pull docker image') {
            steps {
                ansiblePlaybook colorized: true, credentialsId: 'Local', disableHostKeyChecking: true, installation: 'ansible', inventory: 'inventory', playbook: 'deploy-playbook.yml'
                //ansiblePlaybook colorized: true, credentialsId: 'niraj', disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'deploy-playbook.yml'
                // ansiblePlaybook credentialsId: 'shubham', installation: 'Ansible', inventory: 'inventory', playbook: 'deploy-playbook.yml'
            //   ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'deploy-playbook.yml'
            }
        }
    }
}
