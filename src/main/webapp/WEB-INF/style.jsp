<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	/* Style Global */ 
* {
    font-family: 'Courier New', Courier, monospace
}
.btn-primary{
background-color: #CFAB8C;
border-color:  #545454;
}
.page-background {
    background-color: #F2F3EF;
    padding-top: 4em;
    flex: 1;
}
.background{
	background-color: grey;
}
.logo-encherama {
    width: 100px;
    margin: 15px;
}
h1{
    padding-bottom: 20px;
    padding-top: 40px;
    padding-left: 70px;
}
p{
    padding-left:  70px;
    padding-right: 70px;
}
a::before {
    text-decoration: underline;
}

a {
    color: black;
    display: inline-block;
} 
/* Style du Header */ 
.fixed-header {
    background: #CFAB8C;
    color: #fff;
    border-bottom: 1px solid #545454;
    top: 0;
    min-height: 50px;
    display: flex; 
    align-items: flex-end; 
    justify-content: space-between;
}
.logo-top{
    margin-left: 60px;
}

    /* Navigation bar */
    .top-navbar {
        margin-bottom: 0;
    }
    .top-navbar a {
        color: black;
        padding: 8px 50px;
        font-size: 120%;
        border-top: 1px solid #545454;
        border-right: 1px solid #545454;
        border-left: 1px solid #545454;
        border-top-right-radius: 6px;
        border-top-left-radius: 6px;
        vertical-align: middle;
    }
    .top-navbar a:hover {
        background-color: white;
        color: black;
        font-weight: 500;
    }

/* Style du body */
.container{
    background-color: #F2F3EF;
    text-align: justify;
    margin-bottom: 50px;
    padding: 20px 70px 50px 70px
}

 body {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}

/* Style du Footer */
.fixed-footer {
    width: 100%;
    background: #CFAB8C;
    color: black;
    border-top: 1px solid #545454;
    padding-bottom: 0px;
    min-height: 50px;
}

.copyright {
    text-align: center;
    border-top: 1px solid #545454;
}

.logo-rs {
    width: 30px;
}
.footer{
    display: flex; 
    justify-content: center; 
    gap: 5em; 
    align-items: center;

}
.img-rs{
    display: flex; 
    gap: 2em; 
    align-items: flex-start;
}
.footer-rs{
    margin-top: 15px;
}
td a{
    color: black;
}

/* Autres: */

.fichier{
	background-color: #CFAB8C;
	margin-top: 10px;
}
.fichier :hover {
	background-color: white;
	color: #CFAB8C;
}
</style>