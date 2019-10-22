by Ziyi Huang

## Realizing the value of running parallel applications on clusters

### Homework-3 - Steps
1. Implement WordCount Java Application that DOES NOT use MapReduce Framework
2. Use your application to read 3 text files sequentially, each is ~ 10 MB. Run the application on your local machine.
3. Calculate the time of execution for your application
• Hint: You can use System.currentTimeMillis()
4. Now, implement WordCount Java Application using optimized MapReduce Framework with Combiners https://hadoop.apache.org/docs/current/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html#Example:_WordCount_v2.0
5. Run your new application on the Cluster to process the same files that were processed in Step-2
6. Calculate the time of execution for your optimized application.
7. Compare between the performance of the first java application and the optimized version.


### Homework-3 - Deliverables
1. Create GitHub Repository – if you don’t have one already.
2. Create Screenshots for the results of your Java applications that ran locally and on the cluster.
3. Upload your Javafiles,screenshots,InputTextFiles,andOutputText Files to your GitHub Repository.
4. Email the URL for your GitHub Repository to the Instructor by Wednesday, October 23rd, 11:59 PM EST.


### Hadoop Commands Guide
- export JAVA_HOME=/usr/local/jdk1.8.0_101
- export PATH=${JAVA_HOME}/bin:${PATH}
- export HADOOP_CLASSPATH=/opt/cloudera/parcels/CDH/lib/hadoop/hadoop-common.jar:/opt/cloudera/parcels/CDH/lib/hadoop-mapreduce/hadoop-mapreduce-client-core.jar

////////// Move class files to new directory called wordCount

///////// Move test data for input data set to new directory called testData

- hadoop fs -put testData/ .
- jar cvf wordcount.jar -C wordCount/ .
- hadoop jar wordcount.jar WordCount testData output
- hadoop fs -getmerge output collectedResults
- You can add -nl to enable adding newline char after the end of each file
- cat collectedResults
