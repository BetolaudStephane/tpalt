<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body  style="background-color: rgb(89,126,170);">
   	<div style="text-align: center;">
       <h1>Inscription</h1>
    </div>
       
    <div>
	    <form action="inscription.htm" method="POST" > 
			<input type="text" id="name" name="name" placeholder="Nom">
			<input type="text" id="lastName" name="lastName" placeholder="Last name">
			<input type="text" id="email" name="email" placeholder="email">
			<input type="text" id="password" name="password" placeholder="password">
			
			<input type="submit">
			
		</form>
    </div>
   
    
    </body>
</html>
