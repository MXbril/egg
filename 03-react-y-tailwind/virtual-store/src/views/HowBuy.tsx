import Footer from "../components/Footer";
import Hero from "../components/Hero";
import NavBar from "../components/NavBar";

function HowBuy() {
   const steps = [
      {
         title: 'Selecciona un Producto',
         description: 'Busca en nuestro catálogo y elige el producto que más te guste.',
         icon: '📦', // Puedes reemplazar esto con íconos o imágenes.
      },
      {
         title: 'Añade al Carrito',
         description: 'Haz clic en "Agregar al carrito" para guardar tu producto seleccionado.',
         icon: '🛒',
      },
      {
         title: 'Revisa tu Carrito',
         description: 'Accede a tu carrito para verificar los productos y cantidades seleccionadas.',
         icon: '🧾',
      },
      {
         title: 'Finaliza tu Compra',
         description: 'Sigue las instrucciones para completar tu compra y disfrutar de tu producto.',
         icon: '💳',
      },
   ];
   return (
      <>
         <NavBar />
         <Hero first={"tecnología"} second={"renovada"} />
         <main className="max-w-4xl mx-auto p-6 bg-white shadow-lg rounded-lg">
            <h1 className="text-3xl font-bold mb-6 text-center">Cómo Comprar</h1>
            <div className="space-y-8">
               {steps.map((step, index) => (
                  <div key={index} className="flex items-center space-x-4">
                     <div className="text-4xl">{step.icon}</div>
                     <div>
                        <h2 className="text-xl font-semibold">{step.title}</h2>
                        <p className="text-gray-600">{step.description}</p>
                     </div>
                  </div>
               ))}
            </div>
         </main>
         <Footer />
      </>
   )
}
export default HowBuy;