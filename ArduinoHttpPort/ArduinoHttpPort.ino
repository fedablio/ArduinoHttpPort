#include <SPI.h>
#include <String.h>
#include <Ethernet.h>

byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
IPAddress ip(192, 168, 0, 199);
IPAddress gateway(192, 168, 0, 1);
IPAddress subnet(255, 255, 255, 0);
EthernetServer server(8090);
int D2 = 2;
int D3 = 3;
int D5 = 5;
int D6 = 6;
int D7 = 7;
int N0 = A0;
int N1 = A1;
int N2 = A2;
int N3 = A3;
int N4 = A4;
String palavra = "fedablio";
String readString = String(30);

void setup(){
Ethernet.begin(mac, ip, gateway, subnet);
server.begin();
pinMode(D2, OUTPUT);
pinMode(D3, OUTPUT);
pinMode(D5, OUTPUT);
pinMode(D6, OUTPUT);
pinMode(D7, OUTPUT);
pinMode(N0, OUTPUT);
pinMode(N1, OUTPUT);
pinMode(N2, OUTPUT);
pinMode(N3, OUTPUT);
pinMode(N4, OUTPUT);
}

void loop(){
EthernetClient client = server.available();
if (client) {
while (client.connected()){
if (client.available()){
char c = client.read();
if (readString.length() < 30){
readString += (c);
}
if (c == '\n'){
//recebe digital 2
if(readString.indexOf(palavra+"/L2_LIG")>=0){
digitalWrite(D2, HIGH);
}
if(readString.indexOf(palavra+"/L2_DES")>=0){
digitalWrite(D2, LOW);
}
//recebe digital 3
if(readString.indexOf(palavra+"/L3_LIG")>=0){
digitalWrite(D3, HIGH);
}
if(readString.indexOf(palavra+"/L3_DES")>=0){
digitalWrite(D3, LOW);
}
//recebe digital 5
if(readString.indexOf(palavra+"/L5_LIG")>=0){
digitalWrite(D5, HIGH);
}
if(readString.indexOf(palavra+"/L5_DES")>=0){
digitalWrite(D5, LOW);
}
//recebe digital 6
if(readString.indexOf(palavra+"/L6_LIG")>=0){
digitalWrite(D6, HIGH);
}
if(readString.indexOf(palavra+"/L6_DES")>=0){
digitalWrite(D6, LOW);
}
//recebe digital 7
if(readString.indexOf(palavra+"/L7_LIG")>=0){
digitalWrite(D7, HIGH);
}
if(readString.indexOf(palavra+"/L7_DES")>=0){
digitalWrite(D7, LOW);
}
//recebe analógica 0
if(readString.indexOf(palavra+"/N0_LIG")>=0){
digitalWrite(N0, HIGH);
}
if(readString.indexOf(palavra+"/N0_DES")>=0){
digitalWrite(N0, LOW);
}
//recebe analógica 1
if(readString.indexOf(palavra+"/N1_LIG")>=0){
digitalWrite(N1, HIGH);
}
if(readString.indexOf(palavra+"/N1_DES")>=0){
digitalWrite(N1, LOW);
}
//recebe analógica 2
if(readString.indexOf(palavra+"/N2_LIG")>=0){
digitalWrite(N2, HIGH);
}
if(readString.indexOf(palavra+"/N2_DES")>=0){
digitalWrite(N2, LOW);
}
//recebe analógica 3
if(readString.indexOf(palavra+"/N3_LIG")>=0){
digitalWrite(N3, HIGH);
}
if(readString.indexOf(palavra+"/N3_DES")>=0){
digitalWrite(N3, LOW);
}
//recebe analógica 4
if(readString.indexOf(palavra+"/N4_LIG")>=0){
digitalWrite(N4, HIGH);
}
if(readString.indexOf(palavra+"/N4_DES")>=0){
digitalWrite(N4, LOW);
}

client.println("HTTP/1.1 200 OK");
client.println("Content-Type: text/html");
client.println();

//envia digital 2
if (digitalRead(2) == HIGH) {
client.print("D2_LIG");
} 
if(digitalRead(2) == LOW) {
client.print("D2_DES");
}
//envia digital 3
if (digitalRead(3) == HIGH) {
client.print("D3_LIG");
} 
if(digitalRead(3) == LOW) {
client.print("D3_DES");
}
//envia digital 5
if (digitalRead(5) == HIGH) {
client.print("D5_LIG");
} 
if(digitalRead(5) == LOW) {
client.print("D5_DES");
}
//envia digital 6
if (digitalRead(6) == HIGH) {
client.print("D6_LIG");
} 
if(digitalRead(6) == LOW) {
client.print("D6_DES");
}
//envia digital 7
if (digitalRead(7) == HIGH) {
client.print("D7_LIG");
} 
if(digitalRead(7) == LOW) {
client.print("D7_DES");
}
//envia analógica 0
if(digitalRead(N0) == HIGH){
  client.print("J0_LIG");
}
if(digitalRead(N0) == LOW){
  client.print("J0_DES");
}
//envia analógica 1
if(digitalRead(N1) == HIGH){
  client.print("J1_LIG");
}
if(digitalRead(N1) == LOW){
  client.print("J1_DES");
}
//envia analógica 2
if(digitalRead(N2) == HIGH){
  client.print("J2_LIG");
}
if(digitalRead(N2) == LOW){
  client.print("J2_DES");
}
//envia analógica 3
if(digitalRead(N3) == HIGH){
  client.print("J3_LIG");
}
if(digitalRead(N3) == LOW){
  client.print("J3_DES");
}
//envia analógica 4
if(digitalRead(N4) == HIGH){
  client.print("J4_LIG");
}
if(digitalRead(N4) == LOW){
  client.print("J4_DES");
}
readString = "";
client.stop();
}
}
}
}
}
