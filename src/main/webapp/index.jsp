<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
   </head>
     <body>
         <h1>Login Form</h1>
            <%=  10*20 %>
            
              <%  %>
              
              <table border=1>
                   <tr>
                   <th> i </th> 
                   <th> i*i</th>
                   <th>i*i*i </th>
                   </tr>
                   <%! private int n=12; %>
                   <% for(int i=1;i<=n;i++) {%> 
                   <tr>
                      <td> <%= i %> </td>
                      <td> <%= i*i %>
                      <td> <%= i*i*i %>
                   </tr>
                   <% } %>    
              </table>
            
       <form name="Registration" method="post" onsubmit="return verify()" action="register">
            <input type="text" name="firstname" id="firstname"
             placeholder="FIRST NAME">
             <p id="fnerror"> </p>
             <input type="text" name="marks" id="marks" placeholder="MARKS">
             <button type="submit"> SUBMIT </button>
       </form>
       <script>
            function verify(){
           let  firstname=document.getElementById("firstname").value;
           if(firstname==""){
        	   document.getElementById("fnerror").innerHTML = "First name is mandatory";
        	   document.getElementById("fnerror").style.color="red";
        	   return false;
           }
           else{
        	  return true; 
           }
            }
        </script>

       </body>
</html>




