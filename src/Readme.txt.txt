Description:

Proxy server uruchamia się z metody main();
ServerSocket oczekuję na połączenia na porcie 7777;
Po nawiązaniu połączenia i zaakceptowaniu gniazda program tworzy obiekt RequestHandler w osobnym wątku i przekazuje gniazdo
które ma być obsługiwane;
Tworzenie nowego wątka pozwala na jednoczesne obsługiwanie wielu klientów;
Serwer obsługuje połączenia http oraz https;
W zależności od typu połączenia wysyłane są różne komunikaty na serwer docelowy i do klienta (przeglądarki);
Proxy działa tak że wszystkie komunikaty wysyłane od przeglądarki są zapisywane w string bilderze i potem wysyłane z soketu proxy,
dlatego strona internetowa wie tylko o tym że połączenie odbywa się za pomocą proxy ale nie zna nic o kliencie.

How to install:

Żeby korzystać z proxy trzeba skonfigurować przeglądarkę na wysyłanie i odbieranie danych przez proxy server podając 
host: localhost albo 127.0.0.1   i  port 7777;
Po uruchomieniu metody main() można korzystać z przeglądarki jak i zwykle;

Proxy był sprawdzony na Windows w przeglądarce Mozilla Firefox, szczegulnie na youtube.com