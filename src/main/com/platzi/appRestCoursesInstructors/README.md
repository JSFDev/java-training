#### URI RESOURCES
**/test -GET** -String testRest: print message to test
**/instructors -GET** -List&lt;Instructors&gt; getAllInstructors: get all instructor list
**/instructors -POST** -void addInstructor: deserialize instructor by json post and create it.
**/instructors/{idUser} -GET** -Instructor getInstructorById: get especific instructor by id
**/instructors/{idUser}/courses -GET** -List&lt;Courses&gt; getAllCourses: get all coursees from instructor
**/instructors/{idUser}/courses -POST** -void addCourse: deserialize course by json post and apply to instructor
**/instructors/{idUser}/courses/{idCourse} -GET** -Course getCourseById: get especific course from instructor


#### STATUS CLIENT
201 - request to service success
405 - malformed header http request, send application/json
