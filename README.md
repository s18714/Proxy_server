Projekt numer 1 z przedmiotu SKJ
Temat: Serwer proxy HTTP
1. Zadanie polega na napisaniu aplikacji działającej jako serwer proxy HTTP.
2. Aplikacja składa się z jednego procesu pełniącego rolę serwera. Serwer pracuje na zadanym jako parametr porcie TCP i nasłuchuje na nim na połączenia od klientów – przeglądarek WWW. W celu wykorzystania takiego serwera jako proxy, przeglądarkę należy skonfigurować podając w jej konfiguracji adres serwera oraz numer portu (zgodnie z konfiguracją wybranej przeglądarki). Proxy HTTP działa na zasadzie przekazywania żądań – przeglądarka wysyła żądanie ściągnięcia danych nie bezpośrednio do serwera HTTP, a jedynie przekazuje je do pośrednika proxy. Pośrednik łączy się z docelowym serwerem występując jako strona komunikacji HTTP, a uzyskane wyniki przekazuje do klienta (przeglądarki). Należy pamiętać przy tym o konieczności właściwego przekazania do serwera HTTP wszystkich elementów
zapytania HTTP wygenerowanych przez przeglądarkę.
3. Implementację samej funkcjonalności proxy HTTP należy zrealizowana samodzielnie, bez
korzystania z gotowych rozwiązań.
4. Do komunikacji należy używać wyłącznie zwykłych gniazd TCP (klasy ServerSocket i Socket).
5. Projekty powinny zostać zapisane do odpowiednich katalogów w systemie EDUX do
27.11.2019 (termin może zostać zmieniony przez prowadzącego daną grupę).
6. Za poprawne rozwiązanie tego zadania można uzyskać do 4 punktów (plus 1 dodatkowy):
a) Maksymalnie 4 punkty za pełną implementację żądanej funkcjonalności z użyciem własnoręcznie napisanej implementacji pośrednika proxy.
b) Dodatkowo 1 punkt za taką implementację, która będzie w stanie obsłużyć równolegle wiele zapytań od tego samego klienta oraz jednocześnie wielu klientów (wielowątkową).
7. Spakowane archiwum z plikami projektu powinno zawierać:
a) Pliki źródłowe (dla JDK 1.8),
b) Pliki binarne (class),
c) Skrypty startowe, umożliwiające uruchomienie implementacji (opcjonalne), d) Plik Readme.txt z opisem i uwagami autora, w szczególności:
 •
• • • •
szczegółowy opis implementacji (brak opisu może spowodować znaczące obniżenie oceny rozwiązania zadania),
jak zainstalować,
jak uruchomić to co działa,
jak używać,
co nie działa (jeśli nie działa).
