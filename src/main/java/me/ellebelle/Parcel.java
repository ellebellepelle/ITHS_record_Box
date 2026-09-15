package me.ellebelle;

/*
När vi har bestämtos för / vi har tagit emot information om en Box som ska skeppas,
vi har beräknat priset för den, då har vi två värden som vi behöver spara tillsammans.
Och så fort vi behöver spara flera värden tillsammans av olika datatyper eller även
om de är samma datatyp, så kan vi använda records, för att hålla dem tillsammans i minnet.
Så i dethär fallet vill jag spara en Box och ett ShippingPrice.
Så jag gör en ny datatyp/record som kan lagra dethär två sakerna.
 */
public record Parcel(Box box, int shippingPrice) {
}
