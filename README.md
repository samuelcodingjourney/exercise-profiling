## Module 5
### Reflection Answers
1. JMeter is used for performance optimization that simulates real-world loads of the program to measure the behavior of it and asses the system performance such as response time or throughput. On the other hand, IntelliJ Profiler focuses more on runtime analysis and optimization of Java applications that are in development environment. Both target applications to optimize the performance could be differentiated this way between both of them. 
2. Profiling in this case helps on showcasing the detailed information about how much computation resource being consumed and which part in the source code is using it. Therefore, by using profiling developers can optimize the code in order to handle various performance issues and decrease. 
3. Yes. IntelliJ Profiler is very effective when it comes down to assist me on analyzinig and identifying the bottlenecks that made my program run for longer than it should be when accessing the endpoints. Using it, I could perform optimization on certain methods in order to reduce the processing times.
4. The challenges for any developers would be how well that the information gained from profiling could be used to optimize performance throughout the modification of the source code. It would be even harder if further constraints are put placed such as constraints on the maximum or minimum CPU time that the program could do especially when handling a certain size of input data. At the end of the day, if the changes made is not enough to have a noticable impact on the performance then there would be of no use to use profiling in the first place.
5. IntelliJ Profiler comes with IntelliJ ultimate and this is very easy to access and will instantly generate impact when analyzing the various modes that could be used as guidance to optimize the code for a better performance.
6. In order to handle the inconsistent results between the one from JMeter and IntelliJ Profiler is that firstly to try and rerun the program and see the result after. If the result of both does not converge at a certain number then further checking must be applied. These checkings refer to the configuration of both performance testing environment. With the wrong configuration, the overall performance recorded could differ from one another.
7. I optimized three methods. First method was the getAllStudentsWithCourses(), basically I made sure that the queries to the database and retrieval of all students courses at once are more efficient by utilizing studentCourseRepository.findAll() and organizing it into a map of studentCourseMap. Repeated database queries would no longer be needed and could reduce the process time. The next method which is the findStudentWithHighestGpa() is used to streamline the process of finding student with highest GPA. This is used to reduce the manual iterations needed by using the max() operation with comparator. So the stream framework would do the task of finding the maximum GPA. The final method was the joinStudentNames(). The refactor I did was to replace the string concatenation with a StringJoiner. This is because this is just something more efficient for joining large number of strings. The performance is better after using this and resulted in process time reduction. All three of these methods are still functioning the same way they were intended to do originally and one can infer that by reading these changes I just mentioned since none of these would take away those functionalities or even replacing them or erasing some of them alltogether. 