import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function Home() {
  const [services, setServices] = useState([]);

  const { id } = useParams();

  useEffect(() => {
    loadServices();
  }, []);

  const loadServices = async () => {
    const result = await axios.get("http://localhost:8080/services");
    setServices(result.data);
  };

  const deleteServices = async (id) => {
    await axios.delete(`http://localhost:8080/services/${id}`);
    loadServices();
  };

  return (
    <div className="container">
      <h2>Servicios Disponibles</h2>
      <div className="py-4">
        <Link className="btn btn-primary mx-2" to={"/addservice"}>
          Agregar un servicio
        </Link>

        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Nombre</th>
              <th scope="col">Categoría</th>
              <th scope="col">Descrición</th>
              <th scope="col">Herramientas</th>
            </tr>
          </thead>
          <tbody>
            {services.map((services, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{services.name}</td>
                <td>{services.category}</td>
                <td>{services.description}</td>
                <td>
                  <Link
                    className="btn btn-primary mx-2"
                    to={`/viewservice/${services.id}`}
                  >
                    Ver
                  </Link>
                  <Link
                    className="btn btn-outline-primary mx-2"
                    to={`/editrequest/${services.id}`}
                  >
                    Editar
                  </Link>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deleteServices(services.id)}
                  >
                    Borrar
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
