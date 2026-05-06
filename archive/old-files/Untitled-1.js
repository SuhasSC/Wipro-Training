// Cart data
let cart = [
  { id: 1, name: "Laptop", price: 60000, qty: 2, category: "Electronics" },
  { id: 2, name: "Mouse", price: 500, qty: 5, category: "Electronics" },
  { id: 3, name: "Keyboard", price: 1000, qty: 3, category: "Electronics" },
  { id: 4, name: "Monitor", price: 15000, qty: 2, category: "Electronics" }
];


// 1️⃣ Print all product names using map()
const productNames = cart.map(item => item.name);
console.log(`Product Names: ${productNames.join(", ")}`);


// 2️⃣ Total price using reduce()
const totalPrice = cart.reduce((total, item) => total + (item.price * item.qty), 0);
console.log(`Total Price: ₹${totalPrice}`);


// 3️⃣ Filter products with price > 1000 (or user input)
const minPrice = 1000; // you can change this or take input
const filteredProducts = cart.filter(item => item.price > minPrice);

console.log(`Products with price > ${minPrice}:`);
filteredProducts.forEach(item => 
  console.log(`- ${item.name} (₹${item.price})`)
);


// 4️⃣ Function to calculate total quantity
const calculateTotalItems = () =>
  cart.reduce((total, item) => total + item.qty, 0);

console.log(`Total Items: ${calculateTotalItems()}`);


// 5️⃣ Display using template literals (already used above)

// 6️⃣ Arrow functions used everywhere ✅