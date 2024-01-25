class HeaderManager extends HTMLElement {
    connectedCallback() {
        this.innerHTML =
        <body>
        <header>
            <style>
                body {
                padding-top: 60px;
                padding-bottom: 40px;
                display: inline-block;
            }

                .containerHead {
                width: 80%;
                margin: 0 auto;
                /* Centrer DIV*/
                text-align: end;

            }

                .containerFoot {
                width: 80%;
                margin: 0 auto;
                /* Centrer DIV*/
                text-align: center;
                border-top: 1px solid #545454;
                position: relative;
                top: 20px;

            }

                .container {
                width: 80%;
                margin: 0 auto;
                text-align: center;
                /* Centrer DIV*/

            }

                .fixed-header {
                top: 0;
                width: 100%;
                position: absolute;
                background: #CFAB8C;
                padding: 30px 0;
                color: #fff;
                border-bottom: 1px solid #545454;
                left: 0;


            }
            </style>

        <div className="fixed-header">
            <div className="containerHead">
                <!-- Contenu du header -->
                <nav>
                    <a href="./WEB-INF/Inscription.jsp">S'inscrire</a> - <a href="./WEB-INF/connexion.jsp">Se
                    connecter</a>
                </nav>
            </div>
        </div>
        </div>
        </header>
    }
}
    class
    FooterManager
    extends
    HTMLElement {
    connectedCallback() {
    <style>
    .fixed-footer {
            width: 100%;
            position: absolute;
            background: #CFAB8C;
            padding: 30px 0;
            color: #fff;
            border-top: 1px solid #545454;
            bottom: 0;
            left: 0;

        }


        /* style nav*/

    .container p {
            line-height: 200px;
            /* Scrollbar */
        }

    .nav-a {
            color: #004AAD;
            padding: 7px 25px;
            display: inline-block;
            text-decoration: underline;
            position: relative;
            left: 39%;
            top: 40px;
            text-align: center;


        }

    .div-1 {
            color: black;
            font-weight: bold;
            position: relative;
            left:20%;
            top: -10%;
            display: inline-block;
        }


    .div-2 {
            position: relative;
            left: 100px;
            top: -10px;
        }

    .wrapbox {
            width: 5%;
            margin: 0.5%;
            vertical-align: top;
            display: inline-block;
            color: black;
            position: relative;
            left: 60%;
            top: -20px;
            line-break: auto;
        }
    </style>
        <div className="div-1">
            Rejoignez-nous
        </div>

        <div className="nav-a">
            <!-- Contenu du footer -->
            <p>© 2024 Enchèrama Inc.</p>
        </div>

        <div className="wrapbox">
            <a href="#"> Lorem ipsum Lorem ipsum Lorem ipsum</a>
        </div>
        <div className="wrapbox">
            <a href="#"> Lorem ipsum Lorem ipsum Lorem ipsum</a>
        </div>
        <div className="wrapbox">
            <a href="#"> Lorem ipsum Lorem ipsum Lorem ipsum</a>
        </div>
    .
       containerFoot
        {
            width: 80 %;
            margin: 0
            auto; /* Centrer DIV*/
            text - align
        :
            center;
            border - top
        :
            1
            px
            solid
        #
            545454;
            position:relative;
            top:20
            px;
        }


    .
        fixed - footer
        {
            width: 100 %;
            position: fixed;
            background: #CFAB8C;
            padding: 30
            px
            0;
            color: #fff;
            border - top
        :
            1
            px
            solid
        #
            545454
        }


    .
        fixed - footer
        {
            bottom: 0;
        }
    .
        div - 1
        {
            color: black;
            font - weight
        :
            bold;
            position:relative;
            left:150
            px;
            top:-10
            px;
        }
        /* style nav*/

    .
        container
        p
        {
            line - height
        :
            200
            px; /* Scrollbar */
        }
    </style>

    }
}

customElements.define('header-manager', HeaderManager)
customElements.define('footer-manager', FooterManager)