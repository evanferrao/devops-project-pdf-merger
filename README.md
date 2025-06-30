<p align="center">


# Demo Link: https://devops-project-pdf-merger.onrender.com/merge.html

# DevOps Final Project

## Topic: PDF Merger Website

### Submitted by: Evan Ferrao

### Register Number: 23BAI1262

### Email: <evan.ferrao2023@vitstudent.ac.in>

### GitHub Link: https://github.com/evanferrao/devops-project-pdf-merger

### Tools Used: Java, Maven, Git, Puppet, Docker, Ansible, Graphite, Grafana, Jenkins.

## Step 1: Building the Java Application

![](./media/image1.png)

Creating a new Eclipse Project


![](./media/image2.png)

Giving the Project the name 'pdf-merger'


## Step 2: Defining the Java Project in Eclipse

![](./media/image3.png)

Project Structure in Eclipse


![](./media/image4.png)

Details of pom.xml


![](./media/image5.png)

Details of application.properties

![](./media/image6.png)
Details of merge.html (used for UI)


![](./media/image7.png)
Details of MergeController.java


![](./media/image8.png)

Details of PDFMergerApplication.java


![](./media/image9.png)
Details of MergerService.java


## Step 3: Building the Java Application using Maven

![](./media/image10.png)
Running mvn clean


![](./media/image11.png)
Running mvn build


![](./media/image12.png)
Running the jar file created in previous step


## Step 4: Demo of the website

![](./media/image13.png)

Screnshot of website running on localhost port 1234


![](./media/image14.png)

Selecting files for upload


![](./media/image15.png)

Files loaded in the program website


![](./media/image16.png)

Merge Button Pressed => Output file generated


![](./media/image17.png)

Output file downloaded to computer


## Step 5: Setting up deployment with the help of puppet

![](./media/image18.png)
Initial file for deploy.pp for use with puppet


![](./media/image19.png)
Applying the puppet file


![](./media/image20.png)
Checking the status of the puppet deployment


![](./media/image21.png)
Creating Readme for puppet


## Step 6: Git for version control of out PDF Merger Website Application

![](./media/image22.png)
Add files and commit the changes


![](./media/image23.png)
Disable existing pdfmerger service


## Step 7: Docker Setup for deployment through Dockerfile

![](./media/image24.png)
Initial Dockerfile for the deployment


![](./media/image25.png)
Building the docker container


![](./media/image26.png)
Running the docker container


![](./media/image27.png)

Output of docker container running. Thus we have successfully run the pdf merger application using docker container


## Step 8: Ansible Playbook setup for advanced configuration of docker container and automation CI


![](./media/image28.png)
Making ansible folder


![](./media/image29.png)
Ansible playbook deploy.yml


![](./media/image30.png)
Running ansible-playbook


![](./media/image31.png)
Deployment of website using ansible playbook tasks. Thus we have deployed the website using ansible playbook.


## Step 9: Jenkins setup for CI


![](./media/image32.png)
Initial Jenkins config file


![](./media/image33.png)

Configuring Jenkins for building on new commit to repository


![](./media/image34.png)

Linking the local repository on the \@git user of the virtual machine


![](./media/image35.png)
Successfully setup Jenkins CI


![](./media/image36.png)

Jenkins CI build output run


![](./media/image37.png)

Successful deployment using Jenkins which is triggered on push to @master branch of the local git repository


![](./media/image38.png)
Deployment of website automated using Jenkins CI on every push


## Step 10: Setting up graphite and Grafana for monitoring the usage and showing the statistics of websites.

We will be monitoring stats like

1.  PDF's merged

2.  PDF's failed to merge

3.  PDF merge queue

4.  CPU resources

5.  RAM utilization


![](./media/image39.png)
PDF Merge Failures

![](./media/image40.png)
PDF Merge Count

![](./media/image41.png)
PDF Merge Count (when idle)

![](./media/image42.png)
PDF Merge queue size (API Call Queue)
</p>
