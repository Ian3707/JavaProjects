<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        ${SPRING_SECURITY_LAST_EXCEPTION.message}
        <form action="login" method='POST'>
            <table>
                <tr>
                    <td>User:</td>
                    <td><input type='text' name='username' value=''/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='password' value=''/></td>
                </tr>
                <tr>
                    <td><input type='submit' value='Submit'/></td>
                </tr>
            </table>
        </form>
    </body>
</html>