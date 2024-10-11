<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>First JSP App</title>
    </head>
    <body>
        Sum
        <form action="addAlien" method="post">
            Enter id : <input type="number" name="id"/><br>
            Enter name : <input type="text" name="name"/><br>
            <input type="submit"/>
        </form>
        <hr><br>
            Find by name
            <form action="getAlienByName" method="get">
                Enter id: <input type="text" name="name"/>
                <input type="submit"/>
            </form>
        <hr><br>
        Add
        <form action="getAlien" method="get">
            Enter id: <input type="number" name="id"/>
            <input type="submit"/>
        </form>
        <hr><br>
        Delete
        <form action="deleteAlien" method="get">
            Enter id: <input type="number" name="id"/>
            <input type="submit"/>
        </form>
    </body>
</html>