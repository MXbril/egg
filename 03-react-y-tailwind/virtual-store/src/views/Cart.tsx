import { useState, useEffect } from "react";
import CartCard from "../components/CartCard";
import CartResume from "../components/CartResume";
import Footer from "../components/Footer";
import Hero from "../components/Hero";
import NavBar from "../components/NavBar";
import Product from "../interfaces/Product";
import { useDispatch } from "react-redux";
import { calculateTotal } from "../store/actions/products";

function Cart() {
    const [productsOnCart, setProductsOnCart] = useState<Product[]>([]);
    const dispatch = useDispatch();
    useEffect(() => {
      const updateCartProducts = () => {
      const products = localStorage.getItem("cart");
    if (products) {
      setProductsOnCart(JSON.parse(products));
      dispatch(calculateTotal({ products: JSON.parse(products) }));
    } else {
      setProductsOnCart([]); // Vacía el carrito si no hay productos en localStorage
    }
    }; 
    // Inicializar productos en el carrito
    updateCartProducts();

    // Escuchar cambios en localStorage
    window.addEventListener("storage", updateCartProducts);

    // Cleanup listener
    return () => {
      window.removeEventListener("storage", updateCartProducts);
    };
  }, [dispatch]);
  return (
    <>
      <NavBar />
      <Hero first={"mi"} second={"carrito"} />
      <main className="w-full flex flex-col md:flex-row justify-center items-center p-[20px]">
        <section className="flex flex-col">
      {productsOnCart.map((each: Product) => (
        <CartCard
         key={each.id}
         product={each}
         />
        ))}
        </section>
        <CartResume total={90} />
      </main>
      <Footer />
    </>
  );
}

export default Cart;
