package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodeExamples {
    String baseURI=RestAssured.baseURI="HTTP://hrm.syntaxtechs.net/syntaxapi/api";
    String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUyMzczNDgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTI4MDU0OCwidXNlcklkIjoiNTQ0MCJ9.3lKD8CfCK5dZuQnUCqoSS88_3Fkny80vlw_UE9DwRYM";
    static String employee_id;
    @Test
    public void bgetCreateEmployee(){
        RequestSpecification preparedRequest=given().header("Content-Type","application/json").header("Authorization",token).queryParam("employee_id",employee_id);
        //hitting the point
        Response response=  preparedRequest.when().get("/getOneEmployee.php");
       // response.prettyPrint();
        //verifying the assertions/get response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
        String tempEmpId = response.jsonPath().getString("employee.employee_id");

        //we have 2 emp id, one is global and second is local
        Assert.assertEquals(employee_id, tempEmpId);



    }
    @Test
    public void acreateEmployee(){
        //prepare the request
        RequestSpecification preparedRequest= given().header("Content-Type","application/json").header("Authorization",token).body("{\n" +
                "    \"emp_firstname\": \"Song\",\n" +
                "  \"emp_lastname\": \"Sung\",\n" +
                "  \"emp_middle_name\": \"Sang\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1999-05-21\",\n" +
                "  \"emp_status\": \"confirmed\",\n" +
                "  \"emp_job_title\": \"Singer\"\n" +
                "}");
        //hitting the endpoint/ send the request
        Response response=  preparedRequest.when().post("/createEmployee.php");
        //verifying the assertions/get response
        response.then().assertThat().statusCode(201);
        //it will print the output in the console
        //we are capturing employee id from the response
        employee_id=response.jsonPath().getString("Employee.employee_id");
        response.then().assertThat().body("Employee.emp_firstname",equalTo("Song"));
        response.prettyPrint();
        response.then().assertThat().body("Employee.emp_lastname",equalTo("Sung"));
        System.out.println("My test case is passed");
        System.out.println(employee_id);

    }
    @Test
    public void cupdateEmployee(){
        RequestSpecification preparedRequest= given().header("Content-Type","application/json").header("Authorization",token).body("{\n" +
                "  \"employee_id\": \""+employee_id+"\",\n" +
                "  \"emp_firstname\": \"visnja\",\n" +
                "  \"emp_lastname\": \"hasmik\",\n" +
                "  \"emp_middle_name\": \"msa\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2003-05-20\",\n" +
                "  \"emp_status\": \"probation\",\n" +
                "  \"emp_job_title\": \"CEO\"\n" +
                "}");
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
        //for verification
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }
    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //if you want to verify the body of the response.
        //you can do that using hamcrest matchers


    }
    }
