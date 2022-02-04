<form>
<input type="text" name="text" />
<input type="submit" value="submit" />
<h1> Hi There......</h1>
</form>
<%! int num; %>
<%
if (request.getParameter("text") != null)
{
	
    num = Integer.parseInt(request.getParameter("text"));
	//out.println (num);
}
%>
 
<%
for (int i = 1; i <= num; i++)
{
  out.println (i); 
} 
  %>
