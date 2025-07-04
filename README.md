
# eCommerce Demo

A simple Java-based e‑commerce system demonstrating core domain concepts:

- **Products**: physical & digital, with `Expirable` and `Shippable` interfaces  
- **Customer**: holds balance, can purchase items  
- **Cart**: add/remove items, checkout logic (stock, expiry, balance)  
- **Order**: bundles `Customer` + `Cart` + status transitions  

---

## Table of Contents

1. [Assumptions](#assumptions)  
2. [Getting Started](#getting-started)  
3. [Usage & Code Examples](#usage--code-examples)  
4. [Corner Cases](#corner-cases)  
5. [Extending & Testing](#extending--testing)  

---

## Assumptions

1. **Product IDs are unique** across all product types.  
2. **Physical product stock** is decremented only on successful checkout.  
3. **Digital products** have unlimited “stock”.  
4. **Expiry** only applies to `Expirable` products; an expired product cannot be added or purchased.  
5. **Payment** is immediately captured from the customer’s balance at checkout time.  
6. **Order status** flows: `PENDING → PAID → SHIPPED → OUT_FOR_DELIVERY → DELIVERED`.  

---

## Getting Started

```bash
# Clone the repo
git clone https://github.com/YassoKhalid/eCommerce.git
cd eCommerce

# Compile & run
javac -d out/production/eCommerce src/main/java/com/ecomm/**/*.java
java -cp out/production/eCommerce com.ecomm.Main
````

---

## Usage & Code Examples

See [Code Examples](#usage--code-examples) for demonstrations of normal and edge-case behaviors.

---

## Corner Cases

Below are key corner cases with links to code examples and snippet references:

1. [Adding Invalid Quantity](#adding-invalid-quantity)
2. [Checkout with Empty Cart](#checkout-with-empty-cart)
3. [Exact Balance Match](#exact-balance-match)
4. [Multiple Checkouts](#multiple-checkouts)
5. [Shipping-Only Products](#shipping-only-products)

### 1. Adding Invalid Quantity<a name="adding-invalid-quantity"></a>

```java
// Should throw IllegalArgumentException for non-positive quantity
Cart cart = new Cart();
Product p = new DigitalProduct("Sample", 5.00);

try {
    cart.addProduct(p, 0);
} catch (IllegalArgumentException ex) {
    System.out.println(ex.getMessage());
}
```

### 2. Checkout with Empty Cart<a name="checkout-with-empty-cart"></a>

```java
// Empty cart: checkout is a no-op, balance unchanged
Customer c = new Customer("Test", "t@example.com", "01000000000", 100.00);
Cart empty = new Cart();
empty.checkout(c);
System.out.println(c.getBalance()); // Expected: 100.00
```

### 3. Exact Balance Match<a name="exact-balance-match"></a>

```java
// Customer balance equals total cost
Customer c = new Customer("Exact", "e@example.com", "01000000001", 50.00);
Cart cart = new Cart();
cart.addProduct(new DigitalProduct("Item", 25.00), 2);
cart.checkout(c);
System.out.println(c.getBalance()); // Expected: 0.00
```

### 4. Multiple Checkouts<a name="multiple-checkouts"></a>

```java
// Second checkout should throw IllegalStateException
Customer c = new Customer("Multi", "m@example.com", "01000000002", 200.00);
Cart cart = new Cart();
cart.addProduct(new DigitalProduct("D", 10.00), 1);
cart.checkout(c);

try {
    cart.checkout(c);
} catch (IllegalStateException ex) {
    System.out.println(ex.getMessage());
}
```

### 5. Shipping-Only Products<a name="shipping-only-products"></a>

```java
// Product price = 0, shipping fee applied correctly
Customer c = new Customer("Ship", "s@example.com", "01000000003", 20.00);
Cart cart = new Cart();
cart.addProduct(new PhysicalProduct("SampleBox", 0.00, LocalDate.now().plusDays(10), 5.00), 2);
cart.checkout(c);
System.out.println(c.getBalance()); // Expected: 20 - (2*5) = 10.00
```

---

## Extending & Testing

* **Unit Tests**: Add JUnit 5 tests under `src/test/java` to cover all methods.
* **Build Tool**: Convert to Maven/Gradle for dependency & test management.
* **CI**: Add GitHub Actions for automated builds & tests.


