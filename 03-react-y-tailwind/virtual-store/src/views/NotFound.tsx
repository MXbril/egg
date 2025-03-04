import NavBar from "../components/NavBar";
import Hero from "../components/Hero";
import Footer from "../components/Footer";

function NotFound() {
    return(
        <>
        <NavBar/>
        <Hero first={"404"} second={"not found"}/>
        <Footer/>
        </>
    )
}

export default NotFound;