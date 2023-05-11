# Factory Function

Instead of using `new` to create objects, factory functions return the new object when the function is called. that way the programmer have to worry about forgetting the `new` keyword.

```js
const personFactory = (name, age) => {
  const sayHello = () => console.log('hello!');
  return { name, age, sayHello };
};

const jeff = personFactory('jeff', 27);

console.log(jeff.name); // 'jeff'

jeff.sayHello(); // calls the function and logs 'hello!'
```

# Scope and Closure


SECTION B: SQL QUESTIONS (1 QUESTION, 20 MARKS)
Instruction: Please answer ALL the questions..
Based on the following tables. CUSTOMER, INVOICE AND INVOICE ITEM:
write SQL statements to produce the desired results


Table 1: CUSTOMER
CustomerNo | FirstName | LastName | Phone | Email
-----------|-----------|----------|-------|-------
01001 | Ahmad | Fuad | 0128787161 |
C1002 | Julia | Lee | 0196565298 |
C1003 | Meera | Kaur | 0116525654 |
C1004 | Azleenda | Ahmad Selamat | 0183245162 |
C1005 | Nordin | | 0167824544 |
C1006 | Siti | Aminah | 0129874576 |

Table 2: INVOICE
InvoiceNo | CustomerNo | InvoiceDate | Amount(RM)
----------|------------|-------------|-----------
20220301 | 61001 | 01-March-22 | 1396.50
20220302 | C1002 | 01-March-22 | 2516.60
20220303 | 61001 | 07-March-22 | 1673.50
20220304 | C1004 | 08-March-22 | 461.40
20220305 | C1006 | 10-March-22 | 922.80

Table 3: INVOICE_ITEM
InvoiceNo | ItemNo | Item | Quantity | UnitPrice(RM)
----------|--------|------|----------|--------------
20220301 | 2834398 | Cordless Circular Saw | 2 | 415.20
20220301 | 2382125 | Cordless Compact Drill | 1 | 230.70
20220301 | 2129393 | Drill Bit Set 29 pc | 2 | 167.70
20220302 | 2006107 | Cordless Rotary Polisher | 2 | 1258.30
20220303 | 2006107 | Cordless Rotary Polisher | 1 | 1258.30
20220303 | 2834398 | Cordless Circular Saw | 2 | 415.20
20220304 | 2382125 | Cordless Compact Drill | 4 | 230.70
20220305 | 2382125 | Cordless Compact Drill | 2 | 230.70
