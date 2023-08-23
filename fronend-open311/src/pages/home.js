import React, { useEffect, useState } from "react";
import axios from "axios";

export default function Home() {
  const [services, setServices] = useState([]);

  useEffect(() => {
    loadServices();
  }, []);

  const loadServices = async () => {
    const result = await axios.get("http://localhost:8080/services");
    setServices(result.data);
  };

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Nombre</th>
              <th scope="col">Categoría</th>
              <th scope="col">descrición</th>
              <th scope="col">Ubicación</th>
              <th scope="col">Herramientas</th>
            </tr>
          </thead>
          <tbody>
            {services.map((service, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{service.name}</td>
                <td>{service.category}</td>
                <td>{service.description}</td>
                <td>{service.location}</td>
                <td>
                  <button className="btn btn-primary mx-2">Ver</button>
                  <button className="btn btn-outline-primary mx-2">Editar</button>
                  <button className="btn btn-danger mx-2">Borrar</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
