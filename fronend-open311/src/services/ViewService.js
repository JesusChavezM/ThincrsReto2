import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewService() {

  const [service, setService] = useState({
    name: "",
    category: "",
    description: "",
    location: "",
  });

  const { id } = useParams();

  useEffect(()=>{
    loadService();
  },[]);

  const loadService = async ()=>{
    const result=await axios.get(`http://localhost:8080/service/${id}`);
    setService(result.data);
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Detalles de la solicitud</h2>

          <div className="card">
            <div className="card-header">
              Solicitud numero: {service.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Nombre: </b>
                  {service.name}
                </li>
                <li className="list-group-item">
                  <b>Categoria: </b>
                  {service.category}
                </li>
                <li className="list-group-item">
                  <b>Descricion: </b>
                  {service.description}
                </li>
                <li className="list-group-item">
                  <b>Ubicacion: </b>
                  {service.location}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to={"/"}>
            Regresar
          </Link>
        </div>
      </div>
    </div>
  );
}