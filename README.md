# eCommerce Demo

A simple Java-based e‑commerce system demonstrating core domain concepts:

- **Products**: physical & digital, with `Expirable` and `Shippable` interfaces  
- **Customer**: holds balance, can purchase items  
- **Cart**: add/remove items, checkout logic (stock, expiry, balance)  
- **Order**: bundles `Customer` + `Cart` + status transitions  

---

## Table of Contents

1. [Assumptions](#assumptions)  
2. [Prerequisites](#prerequisites)  
3. [Project Structure](#project-structure)  
4. [Getting Started](#getting-started)  
5. [Usage & Code Examples](#usage--code-examples)  
   - Normal Checkout  
   - Expired Product  
   - Out of Stock  
6. [Corner Cases](#corner-cases)  
7. [Extending & Testing](#extending--testing)  
8. [License](#license)  

---

## Assumptions

1. **Product IDs are unique** across all product types.  
2. **Physical product stock** is decremented only on successful checkout.  
3. **Digital products** have unlimited “stock”.  
4. **Expiry** only applies to `Expirable` products; an expired product cannot be added or purchased.  
5. **Payment** is immediately captured from the customer’s balance at checkout time.  
6. **Order status** flows: `PENDING → PAID → SHIPPED → OUT_FOR_DELIVERY → DELIVERED`.  

---

## Prerequisites

- Java 11 or above  
- Maven (or Gradle) if you convert to a build tool  
- Internet connection (for dependency download, if using Maven/Gradle)  

---

## Project Structure

