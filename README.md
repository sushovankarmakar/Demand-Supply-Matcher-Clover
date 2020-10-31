# Demand-Supply Matching - Clover coding challenge
[![Generic badge](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://shields.io/)
[![Generic badge](https://img.shields.io/badge/version-v0.0.1-blue.svg)](https://shields.io/)
[![Generic badge](https://img.shields.io/badge/build%20with-gradle-blueviolet.svg)](https://shields.io/)
[![Generic badge](https://img.shields.io/badge/code%20coverage-92%20%25-red.svg)](https://shields.io/)

##Problem context

Implement a demand-supply matching program for an online market maker.

1. Farmers/Traders publish the availability of the produce with details - quantity and price.These are supply orders.
2. Customers/Traders publish their requirement for the produce - quantity and the best price they can offer. These are demand orders.

All the requirements and the availability are stored in the demand-supply ledger.

The application will match the demand with the supply in the ledger. Whenever a new supply or demand is published; matching is done.

If the requirement cannot be satisfied it continues to remain in the ledger. No expiry is supported.

The program must follow the rules below
1. Priority must be given to "lower supply price - higher demand price" matching. Hence maximizing the profit for the market maker. 

2. The supplier is always given the price he has asked for regardless of the price offered on the demand side.

2. Within the same supply/demand price, first-in-first out rule on time must be followed. First supply must be matched to the first demand.

3. A trade is generated when a buy price is greater than or equal to a sell price. 

As mentioned earlier the trade is recorded at the price of the supply regardless of the price of the demand.

Write a program that accepts supply/demand orders from standard input and writes trades to standard output. 
Do not prompt for input. Please write tests the demonstrate the correct ness of the functionality.

#Example

Example 1: <br/>
The following input format: <br/>
<order-id> <-time> <-produce> <-price/kg> <-quantity in kg>:

s1 09:45 tomato 24/kg 100kg <br/>
s2 09:46 tomato 20/kg  90kg <br/>
d1 09:47 tomato 22/kg 110kg <br/>
d2 09:48 tomato 21/kg  10kg <br/>
d3 09:49 tomato 21/kg  40kg <br/>
s3 09:50 tomato 19/kg  50kg <br/>

order-id starting with 
  - `s` are supply orders
  - `d` are demand orders

Should produce the following output format: <br/>
<demand-order-id> <supply-order-id> <price/kg> <quantity in kg> :

d1 s2 20/kg 90kg <br/>
d1 s3 19/kg 20kg <br/>
d2 s3 19/kg 10kg <br/>
d3 s3 19/kg 20kg <br/> 

Example 2: <br/>

Input: <br/>
d1 09:47 tomato 110/kg 1kg <br/>
d2 09:45 potato 110/kg 10kg <br/>
d3 09:48 tomato 110/kg 10kg <br/>
s1 09:45 potato 110/kg 1kg <br/>
s2 09:45 potato 110/kg 7kg <br/>
s3 09:45 potato 110/kg 2kg <br/>
s4 09:45 tomato 110/kg 11kg <br/>

Output: <br/>
d2 s1 110/kg 1kg <br/>
d2 s2 110/kg 7kg <br/> 
d2 s3 110/kg 2kg <br/>
d1 s4 110/kg 1kg <br/>
d3 s4 110/kg 10kg <br/>

## Solution
This is a solution repo to the above coding problem.

It is a gradle console project.

## Prerequisites

- Java 11 SE or above.
- Gradle 6.3 or above.

### Compile and Execution

For `Gradle` run the following commands to compile & execute

##### Linux

Open a terminal window in the project root, then type and execute the following commands.

```
./gradlew clean build jar
java -jar build/libs/clover.jar <absolute_path_to_input_file>
```

##### Windows

Open a powershell/command window in the project root, then type and execute the following commands.

```
.\gradlew clean build jar
java -jar .\build\libs\clover.jar <absolute_path_to_input_file>
```