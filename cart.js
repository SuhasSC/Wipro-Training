// Sample cart data
const cart = [
  { id: 1, name: "Laptop", price: 60000, qty: 2, category: "Electronics" },
  { id: 2, name: "Mouse", price: 500, qty: 5, category: "Electronics" },
  { id: 3, name: "Keyboard", price: 1000, qty: 3, category: "Electronics" },
  { id: 4, name: "Monitor", price: 15000, qty: 2, category: "Electronics" }
];

// Get all product names
const productNames = cart.map(item => item.name);
console.log(`Product Names: ${productNames.join(", ")}`);

// Calculate total price (price * quantity)
const totalPrice = cart.reduce((sum, item) => sum + item.price * item.qty, 0);
console.log(`Total Price: ₹${totalPrice}`);

// Filter products based on price condition
const minPrice = 1000;
const filteredProducts = cart.filter(item => item.price > minPrice);

console.log(`Products with price greater than ${minPrice}:`);
filteredProducts.forEach(item => {
  console.log(`- ${item.name} (₹${item.price})`);
});

// Function to calculate total quantity of items
const calculateTotalItems = () => {
  return cart.reduce((sum, item) => sum + item.qty, 0);
};

console.log(`Total Items: ${calculateTotalItems()}`);