import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddService() {
  let navigate = useNavigate();

  const [service, setService] = useState({
    name: "",
    category: "",
    description: "",
    location:"",
  });

  const { name, category, description, location } = service;


  const onInputChange = (e) => {
    setService({ ...service, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/service", service);
    navigate("/");
  };


  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2">
          <h2 className="text-center m-4">Realizar Solicitud</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="name" className="form-label">
                Nombre del servicio
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Falta vigilancia"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="category" className="form-label">
                Categoria
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Seguridad"
                name="category"
                value={category}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="description" className="form-label">
                Descripcion
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="No se cuenta con el suficiente personal..."
                name="description"
                value={description}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="location" className="form-label">
                Ubicacion
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Calle #, chihuahua."
                name="location"
                value={location}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <button type="submit" className="btn btn-outline-primary">
              Enviar
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancelar
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
