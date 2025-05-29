import { Outlet } from "react-router-dom";
import Header from "../components/layout/Header";
import Footer from "../components/layout/Footer";

const Layout = () => {
  return (
    <div
      style={{ display: "flex", flexDirection: "column", minHeight: "100vh" }}
    >
      <Header />
      <main style={{ flex: 1 }}>
        <Outlet />
      </main>
      <Footer />
    </div>

    /*
    <div
      style={{ display: "flex", flexDirection: "column", minHeight: "100vh" }}
    >
      <header
        style={{
          background: "lightgray",
          padding: 16,
          fontSize: 24,
          width: "100vw",
        }}
      >
        Header
      </header>
      <main style={{ flex: 1 }}>
        <Outlet />
      </main>
      <footer
        style={{
          background: "lightgray",
          padding: 16,
          fontSize: 24,
          width: "100vw",
        }}
      >
        여기는 footer입니다.
      </footer>
    </div>
    */
  );
};

export default Layout;
