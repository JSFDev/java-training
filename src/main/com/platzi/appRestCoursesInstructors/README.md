#### PATH RESOUCES
**http://localhost:8080**

#### URI RESOURCES
**/test -GET** -String testRest: print message to test
**/instructors -GET** -List&lt;Instructors&gt; getAllInstructors: get all instructor list
**/instructor -POST** -void addInstructor: deserialize instructor by json post and create it.
**/instructor/{idUser} -GET** -Instructor getInstructorById: get especific instructor by id
**/instructor/{idUser}/courses -GET** -List&lt;Courses&gt; getAllCourses: get all coursees from instructor
**/instructor/{idUser}/courses -POST** -void addCourse: deserialize course by json post and apply to instructor
**/instructor/{idUser}/course/{idCourse} -GET** -Course getCourseById: get especific course from instructor


#### STATUS CLIENT
201 - request to service success
405 - malformed header http request, send application/json
