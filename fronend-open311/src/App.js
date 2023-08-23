import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import Home from "./pages/home";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddService from "./services/AddService";

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />}/>
          <Route exact path="/addservice" element={<AddService/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
