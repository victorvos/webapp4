<style>
    @import url("/css/indi.css");
</style>


<div id="indi">
    <form>
        <div id="indiMain" class="indiPart">
            <div class="partTitle">Event</div>
            <hr/>
            <div class="partContent">
                <ul>
                    <li><label for="change">Kans: </label><input name="change" value="90%" readonly/></li>
                    <li><label for="activity">Activiteit: </label><select name="activity">
                        <option value="0">Lipdub</option>
                    </select></li>
                    <li><label for="occasion">Gelegenheid: </label><select name="occasion">
                        <option value="0">Vrijgezellenfeest</option>
                    </select></li>
                    <li><label for="date">Event datum: </label><input name="date" type="date" value="2016-04-29"/></li>
                    <li><label for="startTime">Begintijd: </label><input name="startTime" value="10:00" type="time"/>
                    </li>
                    <li><label for="endTime">Eindtijd: </label><input name="endTime" value="" type="time"/></li>
                    <li><label>Tijdsduur: </label><input type="time" value="03:30" readonly/></li>
                    <li><label for="location">Locatie: </label><input name="distance" type="text" value=""/></li>
                    <li><label for="distance">Afstand (km): </label><input name="distance" type="number" value="20"/>
                    </li>
                    <li><label for="interior">Binnenruimte: </label><select name="interior">
                        <option value="Ja">Ja</option>
                    </select></li>
                    <li><label for="surprise">Verrassing: </label><select name="surprise">
                        <option value="Hele groep">Hele groep</option>
                    </select></li>
                </ul>
            </div>
        </div>

        <div id="indiGroup" class="indiPart">
            <div class="partTitle">Groep</div>
            <hr/>
            <div class="partContent">
                <ul>
                    <li><label for="basePrice">Basisprijs (&euro;): </label><input id="basePrice" name="basePrice"
                                                                                   type="number" value="350" readonly/>
                    </li>
                    <li><label for="nameOrganisation">Naam instantie: </label><input name="nameOrganisation" type="text"
                                                                                     value="5MW"/></li>
                    <li><label for="nameContact">Naam CP: </label><input name="nameContact" type="text"
                                                                         value="Luna van Bennekum"/></li>
                    <li><label for="telContact">Telefoon CP: </label><input name="telContact" type="tel"
                                                                            value="06-19632459"/></li>
                    <li><label for="emailContact">Email CP: </label><input name="emailContact" type="email"
                                                                           value="lunavanbennekum@hotmail.com"/></li>
                    <li><label for="peopleCount">Aantal: </label><input name="peopleCount" type="number" value=""/></li>
                </ul>
            </div>
        </div>

        <div id="indiPrice" class="indiPart">
            <div class="partTitle">Prijs</div>
            <hr/>
            <div class="partContent">
                <ul>
                    <li><label for="basePrice">Basisprijs (&euro;): </label><input name="basePrice" type="number"
                                                                                   value="350" readonly/></li>
                    <li><label for="nameOrganisation">Naam instantie: </label><input name="nameOrganisation" type="text"
                                                                                     value="5MW"/></li>
                    <li><label for="nameContact">Naam CP: </label><input name="nameContact" type="text"
                                                                         value="Luna van Bennekum"/></li>
                    <li><label for="telContact">Telefoon CP: </label><input name="telContact" type="tel"
                                                                            value="06-19632459"/></li>
                    <li><label for="emailContact">Email CP: </label><input name="emailContact" type="email"
                                                                           value="lunavanbennekum@hotmail.com"/></li>
                    <li><label for="peopleCount">Aantal: </label><input name="peopleCount" type="number" value=""/></li>
                </ul>
            </div>
        </div>
    </form>
</div>
