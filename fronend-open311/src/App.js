import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import Home from "./pages/home";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddService from "./services/AddService";
import EditService from "./services/EditService";
import ViewService from "./services/ViewService";

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />}/>
          <Route exact path="/addservice" element={<AddService/>}/>
          <Route exact path="/editrequest/:id" element={<EditService/>}/>
          <Route exact path="/viewservice/:id" element={<ViewService/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
