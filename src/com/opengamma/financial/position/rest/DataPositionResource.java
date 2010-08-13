/**
 * Copyright (C) 2009 - 2010 by OpenGamma Inc.
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.position.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.opengamma.financial.position.master.PositionDocument;
import com.opengamma.financial.position.master.PositionMaster;
import com.opengamma.id.UniqueIdentifier;
import com.opengamma.transport.jaxrs.FudgeRest;
import com.opengamma.util.ArgumentChecker;

/**
 * RESTful resource for a position.
 */
@Path("/data/portfolios/{positionId}")
public class DataPositionResource {

  /**
   * The positions resource.
   */
  private final DataPositionsResource _positionsResource;
  /**
   * The position unique identifier.
   */
  private final UniqueIdentifier _urlPositionId;

  /**
   * Creates the resource.
   * @param positionsResource  the parent resource, not null
   * @param positionId  the position unique identifier, not null
   */
  public DataPositionResource(final DataPositionsResource positionsResource, final UniqueIdentifier positionId) {
    ArgumentChecker.notNull(positionsResource, "position master");
    ArgumentChecker.notNull(positionId, "position");
    _positionsResource = positionsResource;
    _urlPositionId = positionId;
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the positions resource.
   * @return the positions resource, not null
   */
  public DataPositionsResource getPositionsResource() {
    return _positionsResource;
  }

  /**
   * Gets the position identifier from the URL.
   * @return the unique identifier, not null
   */
  public UniqueIdentifier getUrlPositionId() {
    return _urlPositionId;
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the position master.
   * @return the position master, not null
   */
  public PositionMaster getPositionMaster() {
    return getPositionsResource().getPositionMaster();
  }

  /**
   * Gets the URI info.
   * @return the URI info, not null
   */
  public UriInfo getUriInfo() {
    return getPositionsResource().getUriInfo();
  }

  //-------------------------------------------------------------------------
  @GET
  @Produces(FudgeRest.MEDIA)
  public PositionDocument get() {
    return getPositionMaster().getPosition(getUrlPositionId());
  }

  @PUT
  @Consumes(FudgeRest.MEDIA)
  @Produces(FudgeRest.MEDIA)
  public PositionDocument put(PositionDocument request) {
    if (getUrlPositionId().equals(request.getPositionId()) == false) {
      throw new IllegalArgumentException("Document positionId does not match URL");
    }
    return getPositionMaster().updatePosition(request);
  }

  @DELETE
  @Consumes(FudgeRest.MEDIA)
  @Produces(FudgeRest.MEDIA)
  public Response delete() {
    getPositionMaster().removePosition(getUrlPositionId());
    return Response.noContent().build();
  }

  //-------------------------------------------------------------------------
  /**
   * Builds a URI for a position.
   * @param uriInfo  the URI information, not null
   * @param positionId  the position unique identifier, not null
   * @return the URI, not null
   */
  public static URI uri(UriInfo uriInfo, UniqueIdentifier positionId) {
    return uriInfo.getBaseUriBuilder().path(DataPositionResource.class).build(positionId);
  }

}
