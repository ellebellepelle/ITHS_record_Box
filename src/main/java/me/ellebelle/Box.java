package me.ellebelle;

// Jag gör min record i en egen fil för att många andra klasser ska kunna använde den.
// (Om jag bara ska använda recorden internt så kan jag lägga den i samma klass.)
// Jag vill göra ett program som med hjälp av denhär Box-recorden kan registrera paket
// och beräkna om paketet är okej att skicka så det inte är för stort, och checka vad
// priset kan bli.
public record Box(int width, int height, int length) {
}
