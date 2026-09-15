package me.ellebelle;

// En klass som blir mitt pakethanteringssystem.
public class PackageSystem {
    public static void main(String[] args) {

        Parcel[] parcels = new Parcel[10]; // parcels = försendelser
        int parcelCount = 0;


        // ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        while (parcelCount < 10) {
            // Här vill jag registrera paket och deras dimensioner.
            int width = Integer.parseInt(IO.readln("Please enter the width of the box:"));
            int height = Integer.parseInt(IO.readln("Please enter the height of the box:"));
            int length = Integer.parseInt(IO.readln("Please enter the length of the box:"));


            // Validera det / Checka så paketet inte är större än 100x100x100 cm.
            if (width > 100 || height > 100 || length > 100 || width <= 0 || height <= 0 || length <= 0) {
                IO.println("Invalid dimensions. Must be between 1 and 100.");
                continue; // Om jag här har matat in felaktiga värden så gör continue att
                // loopen börjar om på nästa varv.
            }
            // Nu vet jag att jag har gilltig data enl storlek och kan nu göra ett objekt och lagra väderna:
            Box box1 = new Box(width, height, length);


            // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // Beräkna pris för att skicka paketet när det registreras ( för dagen efter
            // kanske vi ändrar priserna. Där av behöver jag lagra priset i samband med att
            // jag registrerar paketet.
            // 1. Paket med alla sidor <= 20 cm kostar 100 kr
            // 2. Paket större än 20 cm kostar 200 kr
            // 3. Skrymmande paket har ett förhållande mellan sidorna som är större
            //    än 1:2 kostar 50 kr extra.
            //    Om ex en sida är 10 cm och en sida är 50 cm så är den sidan 5ggr så
            //    stor som den andra och då vill jag ha 50 kr extra för det.
            //    Men om en sida är 10 och den andra sidan 20 så går det bra för då är
            //    det 1 till 2 i förhållanden mellan sidorna.
            int price = calculateShippingPrice(box1); // En metod som beräknar priset och skickar tillbaka det till price.
            // ctrl + q för att få upp dokumentationen av metoden.

            IO.println("Price is " + price);
            // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // Lagra kostnaden tillsammans med paketets information??
            // Så att jag kan lista alla registrerade paket och deras kostnad utan att
            // behöva beräkna kostnaden om och om igen. Utan jag beräknar kostnaden i
            // samband med registreringen.
            // Får inte uppdatera Box. Box lagrar bara peketets data om dess storlek.
            // Skapar en record-klass som heter ShippingInfo som jag kan skapa ett nytt objekt
            // av och skicka in box1´s storlek och dess pris.

            Parcel parcel = new Parcel(box1, price);
            // behöver jag själva boxen så kan jag göra:
            // shippingInfo.box();
            // få tillgång till kostnaden att skeppa dethär:
            // shippingInfo.shippingPrice();
            parcels[parcelCount++] = parcel;


        }


    }

    // Dokumentation i form av en java-docs-kommentar.

    /**
     * Calculates the shipping price for a given box based on its dimensions.
     * The pricing rules are as follows:
     * - Boxes with all sides less than or equal to 20 cm cost 100 sek.
     * - Boxes with any side greater than 20 cm cost 200 sek.
     * - Bulky boxes, where the ratio between the largest and smallest side exceeds 1:2,
     * incur an additional cost of 50 sek.
     *
     * @param box
     * @return
     */
    private static int calculateShippingPrice(Box box) {
        int price = 0; // Jag behöver en variabel som håller reda på mitt pris.
        if (box.width() <= 20 && box.height() <= 20 && box.length() <= 20) {
            price = 100;
        } else {
            price = 200;
        }

        int maxSide = Math.max(
                Math.max(box.width(), box.height()), // Först körs denna och tar reda på vilket som är störst.
                box.length()                         // Sedan jämförs det resultatet med length.
        );
        int minSide = Math.min(
                Math.min(box.width(), box.height()),
                box.length()
        );
        if (maxSide > 2 * minSide) { // Om största sidan är mer än dubbelt så stor som minsta sidan.
            price += 50;
        }
        return price;
    }
}
