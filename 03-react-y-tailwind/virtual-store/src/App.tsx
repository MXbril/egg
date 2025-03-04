import Details from "./views/Details";
import Cart from "./views/Cart";
import Home from "./views/Home";
import NotFound from "./views/NotFound";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { Provider } from "react-redux";
import store from "./store/index";
import Offers from "./views/Offers";
import HowBuy from "./views/HowBuy";
import CostsFees from "./views/CostsFees";
import Orders from "./views/Orders";
import Warranty from "./views/Warranty";


function App() {
  const browserRouter = createBrowserRouter([
    { path: "/", element: <Home /> },
    { path: "/cart", element: <Cart /> },
    { path: "/details/:id", element: <Details /> },
    { path: "/ofertas/", element: <Offers />},
    { path: "/como-comprar/", element: <HowBuy />},
    { path: "/costo-tarifa/", element: <CostsFees />},
    { path: "/pedidos/", element: <Orders />},
    { path: "/garantia/", element: <Warranty />},
    { path: "/*", element: <NotFound /> },
  ])

  return (
    <Provider store={store}>
     <RouterProvider router={browserRouter} />
    </Provider>
  );
}

export default App;
