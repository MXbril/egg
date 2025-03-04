import { useState } from "react";
import { useSelector } from "react-redux";

function CartResume() {
  const total = useSelector((store) => store.products.total);
  const [cartCleared, setCartCleared] = useState(false);
  const handlePurchase = () => {
    console.log("Compra activada");
    // Aquí puedes agregar la lógica para manejar la compra, como redirigir, mostrar una confirmación, etc.
    alert(`Compra realizada por un total de $${total}`);
    // Vaciar el carrito en el localStorage
    localStorage.removeItem("cart");
    // Actualizar el estado local para forzar la re-renderización
    setCartCleared(true);
    // Despachar evento de almacenamiento
  const storageEvent = new Event('storage');
  window.dispatchEvent(storageEvent);
  };
  return (
    <>
      {cartCleared ? (
        <div className="text-center">Carrito vacío. Gracias por su compra.</div>
      ) : (
        <div className="w-[340px] h-[220px] flex flex-col justify-between rounded-md p-[30px] m-[10px] bg-[#f2f2f2]">
          <div className="flex-grow flex flex-col justify-between">
            <h2 className="flex justify-between text-[20px] font-bold">
              <span>Resumen</span><span>del</span><span>pedido</span></h2>
            <div className="flex justify-between items-center">
              <h3>Total</h3>
              <strong>${total}</strong>
            </div>
            <small className="pb-[10px]">Incluye impuesto PAIS y percepción AFIP.</small>
          </div>
          <button className="w-full h-[40px] bg-[#ff3b3c] text-white font-bold border-0 rounded-md"
            id="buy"
            type="button"
            onClick={handlePurchase} // maneja el click del botón
          >
            COMPRAR
          </button>
        </div>
      )}
    </>
  )
}

export default CartResume;