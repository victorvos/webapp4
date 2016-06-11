<style>
    @import url("css/header.css");
</style>

<div id="header">
    <ul>
        <li>
            <h1 id="title">Boogie</h1>
        </li>
        <li>
            <div id="search">
                <form id="searchForm" action="search.do">
                    <input id="searchInput" type="text" name="search" placeholder="Type hier..." required/>

                    <select id="seachBy" name="by" placeholder="Zoeken...">
                        <option name="name">Naam</option>
                        <option name="filmer">Filmer</option>
                        <option name="comment">Opmerking</option>
                    </select>
                    <input id="seachGo" type="submit" value="Zoek"/>
                </form>
            </div>
        </li>
    </ul>
    <a>
        <div id="settingsIcon" class="fa fa-gear fa-2x"></div>
    </a>
    <a>
        <div id="historyLink" class="fa fa-inbox fa-2x" method="get"></div>
    </a>
    <a>
        <div id="agendaLink" class="fa fa-calendar fa-2x" method="get"></div>
    </a>
</div>