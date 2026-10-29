# Aplicație pentru Evidența și Gestiunea unei Case de Schimb Valutar


## 1. Scopul și Obiectivele Proiectului:

### Scopul
Automatizarea activității dintr-o casă de schimb valutar prin eliminarea operării manuale, asigurarea vitezei de procesare la ghișeu, gestionarea automată a soldurilor de valută per ghișeu și păstrarea unui istoric complet al schimburilor și al cursurilor valutare.

### Obiective operaționale
* **Gestiunea cursurilor de schimb:** Înregistrarea cursurilor de cumpărare, vânzare și BNR actualizate periodic[cite: 4].
* **Evidența tranzacțiilor la ghișeu:** Salvarea datelor de identificare ale clienților (CI/Pașaport, CNP, cetățenie) și generarea chitanțelor[cite: 4].
* **Monitorizarea soldurilor:** Urmărirea stocului fizic de bancnote pe fiecare ghișeu SOLD_GHISEU și înregistrarea transferurilor cu seiful central ALIMENTARE_SEIF.
* **Fidelizare și cazuri speciale:** Aplicarea discounturilor configurate și tratarea cererilor de transfer de numerar între sucursale CERERE_TRANSFER_BANI_SUCURSALE.
* **Niveluri de acces:** Drepturi diferențiate pentru casieri/operatori și administratori/manageri.


## 2. Structura Bazei de Date:

Baza de date este proiectată la Forma Normală 3 și cuprinde următoarele tabele:
1. SUCURSALA – Filialele companiei.
2. GHISEU – Punctele operative din fiecare sucursală.
3. ANGAJAT – Personalul (casieri, manageri).
4. VALUTA – Monedele tranzacționate.
5. CURS_VALUTAR – Istoricul cotațiilor de cumpărare/vânzare.
6. CLIENT – Datele de identificare conform cerințelor legale.
7. TRANZACTIE – Antetul operațiunilor de schimb valutar.
8. DETALII_TRANZACTIE – Detalierea sumelor și cursurilor aplicate.
9. SOLD_GHISEU – Stocul de bancnote existent în sertarul fiecărui ghișeu.
10. ALIMENTARE_SEIF – Transferurile de numerar între seif și ghișee.
11. DISCOUNT – Reguli de reducere aplicate tranzacțiilor mari.
12. CERERE_TRANSFER_BANI_SUCURSALE – Împrumuturi de lichidități între filiale.
