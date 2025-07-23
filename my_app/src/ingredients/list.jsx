import { Link, useLocation } from "react-router-dom";
import {useState, useEffect} from "react";
import axios from "axios";

export default function List() {
    const [list, setList] = useState([]);
    const [pager, setPager] = useState({});
    const location = useLocation();

    useEffect(()=>{
        const query = new URLSearchParams(location.search);
        const nowPage = query.get("nowPage") || 1;
        const search = query.get("search") || "";
        const kind = query.get("kind") || "";
        axios
        .get(`http://localhost:80/ingredients/list?nowPage=${nowPage}&search=${search}&kind=${kind}`)
        .then((d)=> {
            setList(d.data.list);
            setPager(d.data.pager);
        })
        .catch((e)=> console.error("e:",e));
    },[location.search]);

    return (
       <div className="content">
      <div className="container my-5">
        <div className="row g-4">
          <h2 className="mb-4">
            <i className="fas fa-boxes"></i> 원재료 재고 목록
          </h2>

          <table className="table table-bordered table-hover shadow-sm">
            <thead>
              <tr>
                <th>번호</th>
                <th>이름</th>
                <th>재고</th>
                <th>가격</th>
              </tr>
            </thead>
            <tbody>
              {list.map((item) => (
                <tr key={item.ingredientsId}>
                  <td>{item.ingredientsId}</td>
                  <td>{item.ingredientsName}</td>
                  <td>{item.ingredientsStock}</td>
                  <td>
                    {item.ingredientsPrice.toLocaleString()} 원
                  </td>
                </tr>
              ))}
            </tbody>
          </table>

          {/* 페이징 */}
          <div className="row">
            <div className="col-sm-12 col-md-4"></div>
            <div className="col-sm-12 col-md-4">
              <div className="dataTables_paginate paging_simple_numbers">
                <ul className="pagination">
                  <li
                    className={`paginate_button page-item previous ${
                      pager.start <= 1 ? "disabled" : ""
                    }`}
                  >
                    <Link
                      to={`/ingredients/list?nowPage=${pager.start - 1}&search=${pager.search}&kind=${pager.kind}`}
                      className="page-link"
                    >
                      Previous
                    </Link>
                  </li>

                  {Array.from({ length: pager.end - pager.start + 1 }, (_, i) => {
                    const page = pager.start + i;
                    return (
                      <li
                        key={page}
                        className={`paginate_button page-item ${
                          pager.nowPage === page ? "active" : ""
                        }`}
                      >
                        <Link
                          to={`/ingredients/list?nowPage=${page}&search=${pager.search}&kind=${pager.kind}`}
                          className="page-link"
                        >
                          {page}
                        </Link>
                      </li>
                    );
                  })}

                  <li
                    className={`paginate_button page-item next ${
                      pager.endCheck ? "disabled" : ""
                    }`}
                  >
                    <Link
                      to={`/ingredients/list?nowPage=${pager.end + 1}&search=${pager.search}&kind=${pager.kind}`}
                      className="page-link"
                    >
                      Next
                    </Link>
                  </li>
                </ul>
              </div>
            </div>
          </div>

          <Link to="/" className="btn btn-secondary mt-3">
            <i className="fas fa-arrow-left"></i> 홈으로
          </Link>
        </div>
      </div>
    </div>
    )
} 